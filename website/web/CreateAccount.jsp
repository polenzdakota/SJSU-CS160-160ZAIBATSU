<html lang="en">
    <head>
    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Homepage - Not logged in">
        <meta name="author" content="160 Zaibatsu">
        <link rel="icon" href="Images/Hoardr_Icon.ico">

        <title>Hoardr</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this page go here -->
        <link href="css/custom/header_stylesheet.css" rel="stylesheet">
        <link href="css/custom/search_stylesheet.css" rel="stylesheet">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Create New Account</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">
                        <div class="hoardr_icon">
                            <img alt="Brand" src="Images/Hoardr_Icon.png">
                        </div>
                        <div class="navbar-header navbar-fixed-top">
                        </div>
                        <!-- Ebrima Bold is the font for the text on the image -->
                        <form action="${pageContext.request.contextPath}/UserVerify" class="navbar-form navbar-login navbar-fixed-top" role="login" align="right">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Username" name="username">
                                <input type="text" class="form-control" placeholder="Password" name="password">
                            </div>
                            <button type="login" class="custom-button btn btn-default label-success">Login</button>
                        </form>
                    </a>
                </div>
            </div>
        </nav>
    

    	<div class="create-account-page">
			<div class="input-group create-account-form">
                             <form action="${pageContext.request.contextPath}/CreateUser.java"  role="createAccount">
  					<p><a class="create-account-form-text">Username:</a><input type="text" class="form-control" placeholder="Enter Username" name="user"></p>
  					<p><a class="create-account-form-text">Password:</a><input type="text" class="form-control" placeholder="Enter Password" name="pass"></p>
  					<p><a class="create-account-form-text">Verified Password:</a><input type="text" class="form-control" placeholder="Verify Password" name="newVerifiedPassword"></p>
                             </form>	
			</div>
			<button type="createAccount" class="custom-button btn btn-default label-success " name="createAccount">Create Account!</button>

		</div>
    
    
            <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
