window.onload = function() {
    populateCustomers();
};

function populateCustomers() {
    var customerData = [
        {"id":1,"firstName":"Rui","lastName":"Ferrão","email":"rui@gmail.com","phone":"777888"},
        {"id":2,"firstName":"Sergio","lastName":"Gouveia","email":"sergio@gmail.com","phone":"777999"},
        {"id":3,"firstName":"Bruno","lastName":"Ferreira","email":"bruno@gmail.com","phone":"777666"},
        {"id":4,"firstName":"Rodolfo","lastName":"Matos","email":"rodolfo@gmail.com","phone":"777333"}
    ];

    var elementStr;
    var customersTable = document.getElementById("customer-table");
    var row;

    customerData.forEach(function(element) {
        elementStr =
            "<td>" +
            element.firstName +
            "</td>" +

            "<td>" +
            element.lastName +
            "</td>" +

            "<td>" +
            element.email +
            "</td>" +

            "<td>" +
            element.phone +
            "</td>" +

            '<td><button type="button" id="edit-btn-' +
            element.id +
            '" class="edit-btn btn btn-success">edit</button></td>' +
            '<td><button type="button" id="remove-btn-' +
            element.id +
            '" class="remove-btn btn btn-danger">delete</button></td>';

        row = customersTable.insertRow(-1);
        row.innerHTML = elementStr;

        row.setAttribute("id", "custumer-" + element.id);
        row.setAttribute("class", "customer-data");
    });
}
