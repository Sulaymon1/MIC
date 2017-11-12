
$(function () {
    $("#js_register_form").validate({
        rules: {
            name:{
                required: true,
                minlength: 2
            },
            surname:{
                required: true,
                minlength: 3
            },
            lastname:{
                required: true
            },
            email:{
                required: true,
                email: true
            },
            address:{
                required: true
            },
            telefon:{
                minlength: 9,
                digits: true
            },
            username:{
                minlength: 5,
                required:true
            },
            password:{
                minlength: 8,
                required:true
            },
            day:{
                minlength:1,
                required:true,
                maxlength:2
            },
            year:{
                minlength:4,
                required:true,
                maxlength:4
            }
        }
    });
});