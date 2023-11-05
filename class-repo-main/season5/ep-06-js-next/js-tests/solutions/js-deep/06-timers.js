/**
 * Return a stop watch object with the following API:
 * getTime - return number of seconds elapsed
 * start - start counting time
 * stop - stop counting time
 * reset - sets seconds elapsed to zero
 */
exports.createStopWatch = function() {

    var timer;
    var seconds = 0;

    return {
        reset: function() {
            seconds = 0;
        },
        start: function() {
            timer = setInterval(function() {
                seconds += 1;
            }, 1000);
        },
        stop: function() {
            clearInterval(timer);
        },
        getTime: function() {
            return seconds;
        }
    };

};
