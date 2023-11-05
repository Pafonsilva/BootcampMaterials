/**
 * Return an array containing the function arguments
 */
exports.argsAsArray = function(...args) {
    return args;
};

/**
 * Return an array containing the function arguments,
 * but discarding the first two
 */
exports.lastArgs = function(first, second, ...rest) {
    return rest;
};

/**
 * Return a function which applies the provided transform function
 * on all arguments and returns an array with the results
 */
exports.transformArgs = function(transform) {

    return function(...args) {
        return args.map((arg) => transform(arg));
    };
};

/**
 * Invoke the callback function passing each character
 * from the provided string as an argument
 */
exports.spreadChars = function(str, cb) {
    cb(...str);
};

/**
 * Concatenate the provided arrays using the spread operator
 */
exports.mergeArrays = function(arr1, arr2) {
    return [...arr1, ...arr2];
};

/**
 * Return array of chars from the provided array of strings
 */
exports.spreadArrayStrings = function(arr) {

    return arr.reduce((acc, cur) => {
        return [...acc, ...cur];
    }, []);
};

/**
 * Flatten an array of arrays
 */
exports.flattenArray = function(arr) {

    return [].concat(...arr);

    // return exports.spreadArraystrings(arr);
};

