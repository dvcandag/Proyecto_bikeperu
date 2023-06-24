if($("#vistaProducto").length > 0){
    $("#formProducto").on('submit', function(e){
        e.preventDefault();
        var me = $(this).serialize();
        console.table(me);
        alert('submited');
    });
}