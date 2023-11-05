/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function(cb) {

    var t1;
    var t2;

    t1 = Date.now();
    cb();
    t2 = Date.now();

    return t2 - t1;

};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function(value, delay, cb) {

    setTimeout(function() {
        cb(null, value);
    }, delay);

};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function(delay, cb) {

    setTimeout(function() {

        cb(new Error());
    }, delay);
};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function(delay) {

    if (!delay || delay < 0) {
        return Promise.reject();
    }

    return new Promise(function(resolve) {
        setTimeout(resolve, delay);
    });
};

/**
 * Use fetch to grab the contents of both urls and return
 * a promise resolving to the payload concatenation
 */
exports.concatBodies = function(url1, url2) {

    return Promise.all([fetch(url1), fetch(url2)]).then(function(results) {
        return results.reduce(function(acc, curr) {
            return acc + curr;
        });
    });
};
