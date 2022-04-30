$(function() {
	$(document).on('keyup', handleKeyup);
	$('#search').on('click', getOembedData);
});

function handleKeyup(e) {
	const KEY_ENTER = 13;
	if(e.keyCode == KEY_ENTER && $('#url').val().length > 0) {
		return getOembedData();
	}
	
	if(e.keyCode == KEY_ENTER && $('#url').val().length == 0) {
		return alert('검색어를 입력해주세요!');
	}
}

function getOembedData() {
	$.ajax({
		url: '/search?url='+$('#url').val(),
		contentType: 'application/json',
		beforeSend: function() {
			$('body').css('opacity', 0.5);
		},
		success: function(data) {
			var dataObj = data;
			var html = "";
			$('#oembedTable tbody').html(html);
			for(key in dataObj) {
				if(dataObj[key] != null) {
					html += "<tr>";
					html += 	"<td>" + key + "</td>";
					html += 	"<td name='" + key + "'>" + dataObj[key] + "</td>";
					html += "</tr>";
				}
			}
			$('#oembedTable tbody').append(html);
		},
		error: function(err) {
			if(err.responseText != null) {
				$('#oembedTable tbody').html('');
				var html = "<tr align='center'><td>" + err.responseText + "</td></tr>";
				$('#oembedTable tbody').append(html);
			}
		},
		complete: function() {
			$('body').css('opacity', 1);
		}
	})
}