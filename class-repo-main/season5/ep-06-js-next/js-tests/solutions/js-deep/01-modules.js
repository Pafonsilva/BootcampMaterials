/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function(counter) {

    counter = counter || 0;

    return {

        get: function() {
            return counter;
        },

        increment: function() {
            counter++;
        },

        reset: function() {
            counter = 0;
        }
    };
};

/**
 * Creates a person module with an initial name value,
 * should throw exception if not provided
 */
exports.createPerson = function(name) {

    if (!name) {
        throw new Error('name is required');
    }

    var age = 0;

    return {

        getAge: function() {
            return age;
        },

        setAge: function(newAge) {
            age = newAge;
        },

        getName: function() {
            return name;
        }
    };
};
