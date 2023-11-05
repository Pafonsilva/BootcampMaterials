/**
 * Return the result of invoking the provided function
 * If an exception is thrown, return the enclosed error message
 */
exports.callIt = function(fn) {

    try {

        return fn();

    } catch (err) {

        return err.message;
    }
};

/**
 * Return true if the provided arguments are equal,
 * throw an error with an enclosed message otherwise
 */
exports.assertEqual = function(a, b) {

    if (a !== b) {
        throw new Error(a.valueOf() + 'should equal ' + b.valueOf());
    }

    return true;
};

/**
 * Return a custom error constructor with a timestamp property
 * indicating when the error occurred
 */
exports.createCustomError = function() {

    CustomError = function(message) {

        var error = Error(message);
        this.name = 'CustomError';
        this.message = error.message;
        this.stack = error.stack;
        this.timestamp = Date.now();
    };

    CustomError.prototype = Object.create(Error.prototype);
    CustomError.prototype.constructor = CustomError;

    return CustomError;
};
