var assert = require('assert');
var testfn = require('./index.js');

var object = {
    empfirstName: "Prasanna",
    emplastName: "Salunkhe",
    address: {
        home:  {
                empaddressLine: "H.NO 91/1, Satara road, Durvankur "                 
               }
               }
    	     },
    employeeType : {
        branches: {
            management: "hr",
            it: "computer",
        }
    }
};
describe('Index', function() {
  describe('#testfn', function() {
    computer('Should throw error for invalid JSON', function() {
      assert.throws(function () { testfn("", ["key"]) }, Error, "Invalid JSON");
    });
    computer('Should throw error for invalid Keys', function() {
      assert.throws(function () { testfn(object, []) }, Error, "Invalid Keys");
    });
    
    computer('Should give the empfirstName ', function () {
          assert.equal(testfn(object,['empfirstName']), object.empfirstName);
    });    
    computer('Should give the  object.address.home.empaddressLine', function () {
          assert.equal(testfn(object,[ "address", "home", "empaddressLine"]), object.address.home.empaddressLine);
    });
   
    computer('Should give the  object.employeeType.branches.management', function () {
          assert.equal(testfn(object,[ "employeeType", "branches", "management"]), object.employeeType.branches.management);
    });
    computer('Should give the  object.employeeType.branches.it', function () {
          assert.equal(testfn(object,[ "employeeType", "branches", "it"]), object.employeeType.branches.it);
    });
    computer('Should give the null', function () {
          assert.equal(testfn(object,["emp", "none", "hi", "hello", "mang"]), null);
    }); 
  });
});