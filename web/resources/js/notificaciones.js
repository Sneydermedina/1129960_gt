$('#eliminar').click(function () {

    var seleccionados = JSON.stringify($('#table').bootstrapTable('getSelections'));

    if (seleccionados != '[]') {
        var ids = $.map($('#table').bootstrapTable('getSelections'), function (row) {
            return row.mensaje;
        });
        $('#table').bootstrapTable('remove', {
            field: 'mensaje',
            values: ids
        });
    }
});

$('#table').bootstrapTable({
    formatNoMatches: function () {
        return "<div><span class='fa fa-newspaper-o' style='color:#ccc;font-size:275px'></span><h3><strong>No hay novedades en este momento</strong></h3></div>";
    }
});

$('#table2').bootstrapTable({
    formatNoMatches: function () {
        return "<div><span class='fa fa-newspaper-o' style='color:#ccc;font-size:290px'></span><h3><strong>No hay novedades en este momento</strong></h3></div>";
    }
});

