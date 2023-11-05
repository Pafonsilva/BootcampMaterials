let expect = require('expect.js');
let destructuringAnswers = require('../../src/js-next/03-destructuring');

describe('destructuring', () => {

    it('you should be able to use destructuring to discard non interesting properties', () => {

        let chunk = () => { };
        let compact = () => { };

        expect(destructuringAnswers.discardProperties.toString().includes('[')).to.be(false);

        let result = destructuringAnswers.discardProperties({ a: 1, b: 2, chunk, compact });
        expect(result).to.eql({ chunk, compact });

        result = destructuringAnswers.discardProperties({ a: 1, b: 2, compact });
        expect(result).to.eql({ chunk: undefined, compact });

        result = destructuringAnswers.discardProperties({ a: 1, b: 2, chunk });
        expect(result).to.eql({ chunk, compact: undefined });

        result = destructuringAnswers.discardProperties({ a: 1, b: 2 });
        expect(result).to.eql({ chunk: undefined, compact: undefined});

    });

    it('you should be able to destructure methods from native objects)', (done) => {

        const code = destructuringAnswers.getSubstr.toString();

        expect(code.includes('[')).to.be(false);
        expect(code.indexOf('String.prototype')).to.equal(code.lastIndexOf('String.prototype'));

        destructuringAnswers.getSubstr((f1, f2) => {
            expect(f1).to.equal(String.prototype.substr);
            expect(f2).to.equal(String.prototype.indexOf);
            done();
        });
    });
});

