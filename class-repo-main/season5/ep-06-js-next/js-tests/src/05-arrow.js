/**
 * Fix the behaviour of the function
 */
exports.getPerson = function(years, time) {

    return {
        name: 'Pedro',
        age: 5,
        growUp: function() {
            setTimeout(function() {
                this.age += years;
            }, time);
        }
    };
};

/**
 * Fix the behaviour of the function
 */
exports.getArgsAsArray = function() {
    return () => {
        return [].slice.call(arguments);
    };
};

/**
 * Fix the behaviour of the function
 */
exports.getMultiplier = function() {

    return {
        factor: 1,
        getMultiplierFunc: function() {
            return function(value) {
                return this.factor * value;
            };
        }
    };
};

/**
 * Fix the behaviour of the prefixArray method
 */
exports.Prefixer = function Prefixer(prefix) {
    this.prefix = prefix;
};

exports.Prefixer.prototype.prefixArray = function(arr) {

    return arr.map(function(value) {

        return this.prefix + value;
    });
};
