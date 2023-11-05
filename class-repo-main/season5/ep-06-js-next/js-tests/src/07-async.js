/**
 * Fix the async retreive method, doing proper error handling
 * in case fetch does not return a user
 */
exports.User = class {

    constructor(url) {
        this.url = url;
    }

    retreive() {
        return fetch(this.url);
    }
};
