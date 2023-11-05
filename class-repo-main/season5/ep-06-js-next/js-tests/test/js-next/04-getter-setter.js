let expect = require('expect.js');
let getterSetterAnswers = require('../../src/js-next/04-getter-setter');

describe('getters and setters', () => {

    it('you should be able to encapsulate a property behind a getter and a setter', () => {

        let loginObj = getterSetterAnswers.buildLogin();

        loginObj.login = 'login1';
        expect(loginObj.login).to.equal('login1');
        loginObj.login = 'login2';
        expect(loginObj.login).to.equal('login2');

        expect(loginObj.__lookupGetter__('login')).to.be.a('function');
        expect(loginObj.__lookupSetter__('login')).to.be.a('function');
    });
});

