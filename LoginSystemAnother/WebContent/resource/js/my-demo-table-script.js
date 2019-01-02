$(document).ready(function() {

    $(".jqueryDataTable").dataTable({
        "bProcessing": false,
        "bServerSide": false,
        "sAjaxSource": "./FirstServlet",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "id" },
            { "mData": "Call_From"},
            { "mData": "Call_To"},
            { "mData": "Message"}            
        ]
    } ); 
    
});

