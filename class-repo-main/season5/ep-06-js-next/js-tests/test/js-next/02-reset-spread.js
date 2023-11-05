let expect = require('expect.js');
let restSpreadAnswers = require('../../src/js-next/02-rest-spread');

describe('rest/spread', () => {

    it('you should be able to use the rest operator to grab arguments as an array', () => {

        let result = restSpreadAnswers.argsAsArray();
        expect(result).to.be.an('array');
        expect(result.length).to.equal(0);

        result = restSpreadAnswers.argsAsArray(3, 1, 2);
        expect(result).to.be.an('array');
        expect(result).to.eql([3, 1, 2]);

        result = restSpreadAnswers.argsAsArray(1, 2, 3, 4);
        expect(result).to.be.an('array');
        expect(result).to.eql([1, 2, 3, 4]);
    });

    it('you should be able to use the rest operator to grab the remaining arguments', () => {

        let result = restSpreadAnswers.lastArgs();
        expect(result).to.be.an('array');
        expect(result.length).to.equal(0);

        result = restSpreadAnswers.lastArgs(null, 2);
        expect(result).to.be.an('array');
        expect(result.length).to.equal(0);

        result = restSpreadAnswers.lastArgs(null, 2, 3, 4);
        expect(result).to.be.an('array');
        expect(result).to.eql([3, 4]);
    });

    it('you should be able to use the rest operator to aplpy a transform function on all arguments', () => {

        let result = restSpreadAnswers.transformArgs((val) => val + 1);
        expect(result).to.be.a('function');
        expect(result(1, 2, 3)).to.eql([2, 3, 4]);

        result = restSpreadAnswers.transformArgs((val) => val * val);
        expect(result).to.be.a('function');
        expect(result(1, 2, 3)).to.eql([1, 4, 9]);
    });

    it('you should be able to spread each char of a string', () => {

        let timesCalled = 0;

        restSpreadAnswers.spreadChars('test', (...args) => {
            timesCalled += 1;
            expect(args.join('')).to.equal('test');
        });

        restSpreadAnswers.spreadChars('anothertest', (...args) => {
            timesCalled += 1;
            expect(args.join('')).to.equal('anothertest');
        });

        expect(timesCalled).to.equal(2);
    });

    it('you should be able to use spread to concatenate two arrays', () => {

        // making sure the spread operator is used and not concat
        expect(restSpreadAnswers.mergeArrays.toString().includes('...')).to.be(true);
        expect(restSpreadAnswers.mergeArrays.toString().includes('concat')).to.be(false);

        let result = restSpreadAnswers.mergeArrays([1, 2], [3, 4]);
        expect(result).to.eql([1, 2, 3, 4]);

        result = restSpreadAnswers.mergeArrays([], [2, 1]);
        expect(result).to.eql([2, 1]);

        result = restSpreadAnswers.mergeArrays(['a', 'b'], [1, 2]);
        expect(result).to.eql(['a', 'b', 1, 2]);
    });

    it('you should be able to spread an array of strings into an array of chars', () => {

        // making sure the spread operator is used and not concat
        expect(restSpreadAnswers.spreadArrayStrings.toString().includes('...')).to.be(true);
        expect(restSpreadAnswers.spreadArrayStrings.toString().includes('concat')).to.be(false);

        let result = restSpreadAnswers.spreadArrayStrings(['a', 'bcd', 'ef']);
        expect(result).to.be.an(Array);
        expect(result).to.eql(['a', 'b', 'c', 'd', 'e', 'f']);

        result = restSpreadAnswers.spreadArrayStrings(['123', '45', '6']);
        expect(result).to.be.an(Array);
        expect(result).to.eql(['1', '2', '3', '4', '5', '6']);

    });

    it('you should be able to use the spread operator to flatten an array of arrays', () => {

        // making sure the spread operator is used
        expect(restSpreadAnswers.spreadArrayStrings.toString().includes('...')).to.be(true);

        let result = restSpreadAnswers.flattenArray([[1, 2, 3], [4, 5], [6]]);
        expect(result).to.be.an(Array);
        expect(result).to.eql([1, 2, 3, 4, 5, 6]);

        result = restSpreadAnswers.flattenArray([[], [1, 2], [6], ['a', 'b']]);
        expect(result).to.be.an(Array);
        expect(result).to.eql([1, 2, 6, 'a', 'b']);
    });
});
