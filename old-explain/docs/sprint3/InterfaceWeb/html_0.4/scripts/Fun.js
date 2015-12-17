function Fun() {

    var userIsAuthenticated = false;
    var userType;
    var userSessionId;
    var userName;

    //////

    init();

    //////

    function init() {
        $('#javascriptNotEnabledMessage').hide();
        $('#deauthenticationLink').hide();
        $('#dashboardLink').hide();
        $('#myCoursesLink').hide();
        $('#myAccountLink').hide();
        bindEvents();
        $('header').show();
        $('#about').show();
        $('footer').show();
    };

    function bindEvents() {
        $('#dashboardLink').click(function(event) {
            event.preventDefault();
            showPage(Pages.dashboard);
        });

        $('#myCoursesLink').click(function(event) {
            event.preventDefault();
            showPage(Pages.courses);
        });

        $('#myAccountLink').click(function(event) {
            event.preventDefault();
            showPage(Pages.account);
        });

        $('#aboutLink').click(function(event) {
            event.preventDefault();
            showPage(Pages.about);
        });

        $('#addExerciceLink').click(function(event) {
            event.preventDefault();
            showPage(Pages.addExercice);
        });

        $('#authenticationLink').click(function(event) {
            event.preventDefault();
            showPage(Pages.authenticationBox);
        });

        $('#authentificationForm').submit(function(event) {
            event.preventDefault();
            signIn();
        });

        // TESTS

        $('#dev_courseListRefresh').click(function(event) {
            event.preventDefault();
            getCoursesList();
        });

        $('#dev_loginAsProfessor').click(function(event) {
            event.preventDefault();
            dev_logInAs('professor');
        });

        $('#dev_loginAsStudent').click(function(event) {
            event.preventDefault();
            dev_logInAs('student');
        });

    }

    function showPage(page) {
        $('main').children().hide();
        $(page.id).show();
        refreshPage(page);
    };

    function refreshPage(page) {
        switch (page) {
            case Pages.courses:

                getCoursesList();

                break;
            case Pages.dashboard:

                $('#messageOfTheDay').text('Bonjour ' + userName + ' !');
                $('#dashBoardCalendar').fullCalendar({
                });

                break;
            default:
        }
    };

    function signIn() {

        /*
         var authData = {
         'server' : $('#authentificationForm #server').val(),
         'login' : $('#authentificationForm #login').val(),
         'password' : $('#authentificationForm #login').val()
         };

         // Send auth request to server
         var authRequest = $.ajax({
         type : 'GET',
         url : 'http://filltext.com/?rows=1&type=["professor","student"]&name={firstName}&sessionId={randomString|32}',
         // data : authData,
         }).done(function(data) {
         data = ($.parseJSON(data))[0];

         userName = data.name;
         userSessionId = data.sessionId;
         userType = data.type;

         showPage(Fun.Pages.dashboard);

         }).fail(function(data) {
         }).always(function(data) {

         });
         console.log('auth');
         */
        $('#dashboardLink').show();
        $('#myCoursesLink').show();
        $('#myAccountLink').show();

        $('#authenticationLink').hide();
        $('#deauthenticationLink').show();
        showPage(Pages.dashboard);

    }

    function signOut() {
        console.log('LOG OUT !');
        userIsAuthenticated = false;
        $('#dashboardLink').hide();
        $('#myCoursesLink').hide();
        $('#myAccountLink').hide();
        $('#deauthenticationLink').hide();
        $('#authenticationLink').show();
        showPage(Pages.about);
    };

    function getCoursesList() {

        var request = $.ajax({
            type : 'GET',
            url : 'http://filltext.com/?rows=8&id={randomNumberLength}&name={streetAddress}',
        }).done(function(data) {
            data = $.parseJSON(data);

            // Cleaning courses list
            $('#coursesTable').children().remove();
        $('#coursesTable').append($('<tr>').html('<td>Course ID</td><td>Course Name</td>'));
            for (i in data) {
                // Create course item
                var new_row = '<td>' + data[i].id + '</td><td>' + data[i].name + '</td>';
                $('#coursesTable').append($('<tr>').html(new_row));
                    
            }
        }).fail(function(data) {
        }).always(function(data) {
        });
    }

    // POUR TESTS

    function dev_logInAs(type) {
        userIsAuthenticated = true;

        if (type == 'professor') {
            userType = 'professor';
            userName = 'Bernard LeProf';
            userSessionId = 'azertyuiop';
        } else if (type == 'student') {
            userType = 'student';
            userName = 'Sarah LaEtudiante';
            userSessionId = 'qsdfghjklm';
        } else {
            console.error('devlogin error !');
        }
        signIn();
    }

}
