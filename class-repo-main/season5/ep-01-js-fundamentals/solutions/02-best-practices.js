/**
 * Best Practices Answers
 */

/**
 * Obtain user details
 */
exports.getUser = function () {
    // a vantagem disto é que ?
    return {
        name: 'Pedro',
        email: 'pedro.antoninho@academiadecodigo.org'
    };
};

/**
 * Convert String to Number
 */
exports.parseNumber = function(num) {
    return parseInt(num, 10); // o 2º argumento é o radix, que identifica o sistema numeral
};

/**
 * Tests for equality
 */
exports.isEqual = function(val1, val2) {
    return val1 === val2;
};
