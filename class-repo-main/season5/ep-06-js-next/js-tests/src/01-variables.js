/**
 * Should return array of number returning functions from 0 to times
 * Use block scope (not closure) to fix this
 */
exports.numberReturningFuncs = function(times) {

    var fs = [];

    for (var i = 0; i < times; i++) {
        fs.push(() => i);
    }

    return fs;
};

/**
 * Prevent variable reassignment
 */
exports.reassignVariable = function() {

    let a = 1;

    {
        let a = 1;
        a = 2;
    }
};
