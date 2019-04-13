<!DOCTYPE html>
<html>
<head>
<!-- Reload every minute -->
<meta http-equiv="refresh" content="60" />
<title>RCF</title>
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Mono:400,400i,600" rel="stylesheet">
<style>
    body {
	background: #222;
	color: #DDD;
        max-width: 700px;
        margin: 0 auto;
        font-family: 'IBM Plex Mono', Verdana, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	font-size: 20px;
    }
    .quiet {
    	color: #555;
	text-align: right;
    }
    a{
    	color: #9393ff;
	text-decoration: none;
    }
    @media only screen and (max-width : 700px) {
	body{
	    font-size: 18px;
	}
    }
    @media only screen and (max-width : 500px) {
	body{
	    font-size: 16px;
	}
    }
</style>
</head>
<body>
<h1>Welcome to RCF.MADHACKER.BIZ</h1>
<p>If you see this page, the server is up. No site directory is provided. Experiments are linked directly in their respective articles. Services are available at the ports defined in relevant articles and experimental logs. If you're here, it is likely because you clicked <b>19&Omega;</b> link. All the important ports are secret and hidden, anyhow.
<?php
echo date("l") . "'s datestamp is <b>RCF" . date("Ymd") . "</b>.";
?></p> 
<h3><u>System Information</u></h3>
<?php
echo "<b>CPU0</b> Temperature: " . trim(shell_exec("/home/rflec028/ryanfleck.github.io/globalscripts/pi_temp")) . "&#176;C.<br>";
echo "System has been " . trim(shell_exec("uptime -p")) . ".<br>";
?> 
<br />
