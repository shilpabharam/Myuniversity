app.directive('exampleFocus', function ($timeout) {
    return {
        scope: {
            trigger: '@exampleFocus'
        },
        link: function (scope, element) {
            scope.$watch('trigger', function () {
                $timeout(function () {
                    element[0].focus();
                });
            });
        }
    };
});

app.directive('exampleHasError', function ($timeout) {
    return {
        restrict: "A",
        link: function (scope, element) {
            $timeout(function () {
                var input = element.find('input[data-ng-model]');
                if (input) {
                    scope.$watch(function () {
                        return (input.hasClass('ng-invalid') && input.hasClass('ng-dirty'));
                    }, function (isInvalid) {
                        element.toggleClass('has-error', isInvalid);
                    });
                }
            });
        }
    };
});

app.directive('nxEqual', function() {
    return {
        require: 'ngModel',
        link: function (scope, elem, attrs, model) {
            if (!attrs.nxEqual) {
                console.error('nxEqual expects a model as an argument!');
                return;
            }
            scope.$watch(attrs.nxEqual, function (value) {
                model.$setValidity('nxEqual', value === model.$viewValue);
            });
            model.$parsers.push(function (value) {
                var isValid = value === scope.$eval(attrs.nxEqual);
                model.$setValidity('nxEqual', isValid);
                return isValid ? value : undefined;
            });
        }
    };
});
