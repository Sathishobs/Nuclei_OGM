var app = angular.module('app', [ 'ngDraggable' ]);

app.controller('MainCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$scope.centerAnchor = true;
	$scope.toggleCenterAnchor = function() {
		$scope.centerAnchor = !$scope.centerAnchor
	}
	$scope.draggableObjects = [ {
		UUID : '10001',
		name : 'Server',
		version : '1.1'
	}, {
		tbUUID : '20001',
		tbname : 'Neo4j',
		tbVersion : 'v1.0'
	} ];

	$scope.droppedObjects1 = [];

	$scope.onDropComplete1 = function(data, evt) {
		//console.log("The value is : ", data);

		$scope.name = data.name;
		$scope.tbname = data.tbname;

		var index = $scope.droppedObjects1.indexOf(data);
		if (index == -1)			
			$scope.droppedObjects1.push(data);
	}

	$scope.submit = function() {		

		var response = $http({
			method : 'POST',
			url : '/template',
			params : {
				tbname : $scope.droppedObjects1.pop().tbname,
				name : $scope.droppedObjects1.pop().name
			}
		});

		response.success(function(data, status, headers, config) {
			//alert("Success..!");
			//console.log(data);
			$scope.successMsg = data;
		});
		response.error(function(data, status, headers, config) {			
			if (status == 400) {
				$scope.errMessages = data;
			} else {
				alert('Unexpected server error.');
			}

		});	
	}

	$scope.onDragSuccess1 = function(data, evt) {
		var index = $scope.droppedObjects1.indexOf(data);
		if (index > -1) {
			$scope.droppedObjects1.splice(index, 1);
		}
	}

	var inArray = function(array, obj) {
		var index = array.indexOf(obj);
	}

} ]);