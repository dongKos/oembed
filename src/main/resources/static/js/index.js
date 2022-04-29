$(function() {
	$('#search').on('click', getOembedData);
});

function getOembedData() {
	$.ajax({
		url: '/search?url='+$('#url').val(),
		contentType: 'application/json',
		success: function(data) {
			var dataObj = data;
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
			if(err.responseText != null) {
				$('#oembedTable tbody').html('');
				var html = "<tr align='center'><td>" + err.responseText + "</td></tr>";
				$('#oembedTable tbody').append(html);
			}
		}
	})
}