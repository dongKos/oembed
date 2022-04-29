$(function() {
	$('#search').on('click', getOembedData);
});

function getOembedData() {
	$.ajax({
		url: '/search?url='+$('#url').val(),
		contentType: 'application/json',
		success: function(data) {
			var dataObj = data;
			/* var objectOrder = {
				title: null,
				type: null,
				version: null
			};
			
			dataObj = Object.assign(objectOrder, dataObj);*/
			var html ="";
			$('#oembedTable tbody').html('');
			for(key in dataObj) {
				if(dataObj[key] != null) {
					html += "<tr>";
					html += 	"<td>" + key + "</td>";
					html += 	"<td>" + dataObj[key] + "</td>";
					html += "</tr>";
				}
			}
			$('#oembedTable tbody').append(html);
		},
		error: function(err) {
			console.log(err);
			if(err.status == 500 && err.responseText != null) {
				console.log(err.responseText);
			}
		}
	})
}