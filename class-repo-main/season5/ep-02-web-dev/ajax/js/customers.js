var API_URL = "http://192.168.1.53:8080/javabank5/api/customer";

window.onload = function () {
    fetchCustomers();
};

function fetchCustomers() {
    var customersData;
    var httpRequest;

    if (window.XMLHttpRequest) {
        // Mozilla, Safari, IE7+ ...
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        // IE 6 and older
        /* jshint -W117 */
        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        /* jshint +W117 */
    }

    // set http request callback function
    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            usersData = httpRequest.responseText;
            populateCustomers(JSON.parse(usersData));
        }
    };

    // sending an HTTP GET request
    httpRequest.open("GET", API_URL, true);
    httpRequest.setRequestHeader("Content-type", "application/json");
    httpRequest.send();
}

function populateCustomers(customerData) {
    var elementStr;
    var customersTable = document.getElementById("customer-table");
    var row;

    customerData.forEach(function (element) {
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
