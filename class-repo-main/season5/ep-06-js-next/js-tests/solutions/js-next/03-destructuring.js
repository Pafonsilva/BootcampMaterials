/**
 * Discard all properties except for chunk and compact
 * from the provided object API using destructuring
 */
exports.discardProperties = function(obj) {

    let { chunk, compact } = obj;
    return {
        chunk,
        compact
    };
};

/**
 * Pass the substr and indexof methods found on each string
 * as arguments to the provided function, making use of object destructuring
 */
exports.getSubstr = function(func) {
    let { substr, indexOf } = String.prototype;
    func(substr, indexOf);
};
