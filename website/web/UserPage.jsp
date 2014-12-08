<!DOCTYPE html>
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
        <title>User Home Page</title>
    </head>
    <body>	
		<%
            //Check for current user and sets user if currently loged in.
            //Redirects to home page if not logged in and attempted
            // to access page directly
            String currentUser = null;
            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("HomePage.jsp");
            } else {
                currentUser = (String) session.getAttribute("user");
            }
        %>    

    
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">
                        <div class="hoardr_icon">
                            <img alt="Brand" src="Images/Hoardr_Icon.png">
                        </div>
                        <div class="navbar-header navbar-fixed-top">
                        
                        <form action="${pageContext.request.contextPath}/LogOut" class="navbar-form navbar-login navbar-fixed-top" role="login" align="right">
                            <p class= "username-text">Logged in as: ${currentUser}</p>
       						 <form action="${pageContext.request.contextPath}/LogOut" class="logout-button">	
            					<button type="logout" class="custom-button btn btn-default label-success">Logout</button>
        					</form>
                        </form>
                        
                        
                        
                        
                        	
                        </div>
                    </a>
                </div>
            </div>
        </nav>
		
		<nav class="navbar navbar-inverse navbar-fixed-top secondary-navbar" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<ul class="nav nav-tabs nav-justified ">
						<li><a class="active-tab" href="HomePage.jsp">Search</a></li>
						<li><a href="ViewCollection.jsp">Collection</a></li>
						<li><a href="AccountInfo.jsp">Account</a></li>
					</ul>
				</div>
			</div>
		</nav>


        <div class="container">

            <div class="homepage-text-not-logged-in">
                <h1>Welcome to <mark class="hoardr-text">HOARDR</mark></h1>
                <p class="lead">Enter any Magic the Gathering card name below.</p>
            </div>

            <!-- Seach bar --> 
            <!-- https://blog.twitter.com/2013/twitter-typeaheadjs-you-autocomplete-me -->
            <!-- the site above should be used as a reference for auto completing searches -->
            <div class="search-bar">
                <form class="navbar-form navbar-center text-center" action="${pageContext.request.contextPath}/CardSearch" role="search">
                    <div class="form-group">
                        <input type="text" autofocus="autofocus" class="form-control" name="card_name">
                    </div>
                    <button type="submit" class="custom-button btn btn-default label-success">Search</button>
                </form>
            </div>
        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
