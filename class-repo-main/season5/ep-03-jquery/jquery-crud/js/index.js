var API_URL = 'http://localhost:8090/javabank5/api/customer';

var uiValidator = formValidationModule();
var customerService = customerServiceModule();

// dom ready callback function
$(document).ready(function() {
    // setup ui event handlers
    setupUI();

    // load users from the java spring rest api
    loadCustomers(displayCustomers);
});

function setupUI() {
    setupAddCustomerHandler();
    setupUpdateCustomerHandler();
    setupClearUiHandlers();
}

// loads customer data
function loadCustomers(cb) {
    customerService.list(function(error, data) {
        if (error) {
            displayInfo(
                'customer-list-info',
                'Error fetching customers..',
                'alert-danger'
            );
            return;
        }

        cb(data);
    });
}

// displays the fetched customer data
function displayCustomers(data) {
    $('.customer-data').remove();

    data.forEach(function(element) {
        element =
            '<tr id="customer-' +
            element.id +
            '" class="customer-data">' +
            '<td>' +
            element.firstName +
            '</td>' +
            '<td>' +
            element.lastName +
            '</td>' +
            '<td>' +
            element.email +
            '</td>' +
            '<td>' +
            element.phone +
            '</td>' +
            '<td><button type="button" id="edit-btn-' +
            element.id +
            '" class="edit-btn btn btn-success">edit</button></td>' +
            '<td><button type="button" id="remove-btn-' +
            element.id +
            '" class="remove-btn btn btn-danger">delete</button></td>' +
            '</tr>';
        $(element).appendTo('#customer-table');
    });

    setupEditCustomerHandler();
    setupDeleteCustomerHandler();
}

// clears the ui textfields
function resetUI() {
    $('#update-id').val('');
    $('#firstname').val('');
    $('#lastname').val('');
    $('#email').val('');
    $('#phone').val('');
}

function setupAddCustomerHandler() {
    $('#add-btn').click(function() {
        if (!uiValidator.validate()) {
            return;
        }

        var customer = {
            firstName: $('#firstname').val(),
            lastName: $('#lastname').val(),
            email: $('#email').val(),
            phone: $('#phone').val()
        };

        customerService.add(customer, function(error, data) {
            if (error) {
                displayInfo(
                    'customer-data-info',
                    'Error adding customer..',
                    'alert-danger'
                );
                return;
            }

            displayInfo(
                'customer-data-info',
                'Customer sucessfully added',
                'alert-success'
            );
            loadCustomers(displayCustomers);
        });
    });
}

function setupUpdateCustomerHandler() {
    $('#update-btn').click(function() {
        if (!uiValidator.validate()) {
            return;
        }

        var id = $('#update-id').val();
        var customer = {
            id: id,
            firstName: $('#firstname').val(),
            lastName: $('#lastname').val(),
            phone: $('#phone').val(),
            email: $('#email').val()
        };

        customerService.update(customer, function(error, data) {
            if (error) {
                displayInfo(
                    'customer-data-info',
                    'Error updating customer..',
                    'alert-danger'
                );
                return;
            }

            displayInfo(
                'customer-data-info',
                'Customer sucessfully updated',
                'alert-success'
            );
            loadCustomers(displayCustomers);
        });
    });
}

function setupEditCustomerHandler() {
    $('.edit-btn').click(function(event) {
        $('.info').css('visibility', 'hidden');

        var button = event.target;
        var id = button.id.split('-')[2];
        var customer = customerService.find(Number.parseInt(id));

        $('#update-id').val(customer.id);
        $('#firstname').val(customer.firstName);
        $('#lastname').val(customer.lastName);
        $('#email').val(customer.email);
        $('#phone').val(customer.phone);
    });
}

function setupClearUiHandlers() {
    // disable toast notification when buttons are clicked
    $('button').click(function() {
        $('.info').css('visibility', 'hidden');
    });

    // clear customer form when reset buttin is clicked
    $('#reset-btn').click(function() {
        resetUI();
    });
}

function setupDeleteCustomerHandler() {
    $('.remove-btn').click(function(event) {
        $('.info').css('visibility', 'hidden');

        var button = event.target;
        var id = button.id.split('-')[2];

        customerService.delete(id, function(error) {
            if (error) {
                displayInfo(
                    'customer-data-info',
                    'Error deleting customer..',
                    'alert-danger'
                );
                return;
            }

            displayInfo(
                'customer-data-info',
                'Customer successfully deleted',
                'alert-warning'
            );

            loadCustomers(displayCustomers);
        });
    });
}

function displayInfo(elementId, message, cssClass, visibility) {
    if (visibility === undefined) {
        visibility = 'visible';
    }

    var element = $('#' + elementId);
    element.removeClass();
    element.addClass('info alert ' + cssClass);

    element.html(message);
    element.css('visibility', visibility);
}

function customerServiceModule() {
    var customers;

    function ajax(endpoint, cb) {
        $.ajax({
            url: endpoint.url,
            type: endpoint.type,
            async: true,
            contentType: 'application/json',
            data: endpoint.data ? JSON.stringify(endpoint.data) : undefined,
            success: function(data) {
                cb(null, data);
            },
            error: cb
        });
    }

    return {
        list: function(cb) {
            ajax({ url: API_URL }, function(error, data) {
                if (error) {
                    cb(error);
                    return;
                }

                customers = data;
                cb(null, customers);
            });
        },
        add: function(customer, cb) {
            ajax({ url: API_URL, type: 'POST', data: customer }, cb);
        },
        update: function(customer, cb) {
            ajax(
                {
                    url: API_URL + '/' + customer.id,
                    type: 'PUT',
                    data: customer
                },
                cb
            );
        },
        find(id) {
            return customers.find(function(customer) {
                return customer.id === id;
            });
        },
        delete(id, cb) {
            ajax({ url: API_URL + '/' + id, type: 'DELETE' }, cb);
        }
    };
}

function formValidationModule() {
    return {
        validate: function() {
            return $('#data-form')
                .validate()
                .form();
        }
    };
}
