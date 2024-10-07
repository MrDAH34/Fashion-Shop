// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
      "columnDefs": [
          { "orderable": false, "targets": [0,4,6,7,8,9] } 
      ]
  });
});
