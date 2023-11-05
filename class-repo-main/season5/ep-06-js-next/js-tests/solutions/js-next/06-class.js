/**
 * Create a Prefixer class with constructor and a prefixArray method
 */
exports.Prefixer = class {

    constructor(prefix) {
        this.prefix = prefix;
    }

    prefixArray(arr) {
        return arr.map(value => this.prefix + value);
    }
};

/**
 * Create a PrefixerSuffixer class which extends from the Prefixer class
 * but adds a sufixArray method
 */
exports.PrefixerSufixer = class extends exports.Prefixer {

    constructor(prefix, sufix) {
        super(prefix);
        this.sufix = sufix;
    }

    sufixArray(arr) {
        return arr.map(value => value + this.sufix);
    }
};
