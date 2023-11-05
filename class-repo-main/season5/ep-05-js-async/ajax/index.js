// Put all js code here, avoid mixing js inside html template

var API_ENDPOINT = 'https://api.exchangeratesapi.io/latest';

// make sure the DOM is ready, window.onload does not provide
// consistent behaviour across browsers
$(document).ready(function() {

    // bind the event handler to the input box
    $('#amount').change(onChangeHandler);

    function onChangeHandler(event) {

        var amount = event.target.value;

        // use error first async callback style
        fetchData(function(error, results) {

            // exception case upfront
            if (error) {
                renderError(error);
                return;
            }

            // generic case at the bottom
            renderResults(amount, results.rates)
        });
    }

    // performs ajax request, no dom manipulation here
    function fetchData(cb) {

        // abstract old jquery success/error callbacks to
        // single error first callback
        $.ajax({
            url: API_ENDPOINT,
            type: 'GET',
            dataType: 'json',
            success: function(results) {
                cb(null, results);
            },
            error: function(request) {
                cb('Error fetching rates' + (request.responseText ? ': ' + request.responseText : ''));
            }
        });
    }

    // renders results, no ajax code here
    function renderResults(amount, rates) {
        var usd = rates.USD * amount;
        $('#rate').html('<p>' + amount + ' EUR = ' + usd + ' USD</p>');
    }

    // renders error, no ajax code here
    function renderError(error) {
        $('#rate').html('<p style="color: red;">' + error + '</p>');
    }
});
