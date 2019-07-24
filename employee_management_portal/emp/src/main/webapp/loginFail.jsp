<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- <link rel="stylesheet" href="./font/font-awesome-4.7.0/css/font-awesome.css"> -->
    <link rel="stylesheet" href="bootstrap.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>

<body>
<br/>
<br/>
<br/>
<br/>
<br/>

    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-3 card" style="background-color: lemonchiffon">
                <div class="card-body">
                    <h4 class="text-center border-bottom">Login Form</h4>
                    <br>
                    <form action="login" method="post">
                        <div class="row">
                            <div class="col-md-12">
                             <label style="color: red"></label> 
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label>Emp ID</label> <input class="form-control"
                                            type="empId" name="empId" placeholder="Enter Employee ID" />
                                    </div>
                                </div>

                                <span id="email-error" style="display: none" class="text-danger small"></span>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Password</label>
                                        <!-- <div class="input-group row ">
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" id="id"
                                                    placeholder="Enter Password" onkeyup="validateForm()">
                                            </div>
                                            <div class="input-group-prepend col-md-2">
                                                <div class="input-group-text">ID</div>
                                            </div>
                                        </div> -->
                                        <div class="row">
                                            <div class="col-md-12 pr-0">

                                                <input class="form-control " type="password"
                                                    name="password" placeholder="Enter Password" id="password" /><span
                                                    class="input-group-btn">
                                            </div>
                                            <!-- <div class="col-md-1 p-0">
                                                <button class="btn btn-default reveal" onclick="showPassword()"
                                                    type="button"><i class="glyphicon glyphicon-eye-open"></i></button>
                                            </div> -->
                                        </div>
                                        <input type="checkbox" id="cbpassword"><span style="font-size: 12px;">Show
                                            Password</span>
                                    </div>
                                </div>
                                <span class="text-danger small" id="password-error" style="display: none"></span>

                               <!--  <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label>Confirm Password</label>
                                        <div class="row">
                                            <div class="col-md-11 pr-0">
                                                <input onkeyup="validateForm()" class="form-control" type="password"
                                                    name="confirm_password" placeholder="Confirm Password"
                                                    id="confirm_password" />
                                            </div>
                                            <div class="col-md-1 p-0">
                                                <button class="btn btn-default reveal" onclick="showConfirmPassword()"
                                                    type="button"><i class="glyphicon glyphicon-eye-open"></i></button>
                                            </div>
                                        </div>
                                        <input type="checkbox" id="cfcbpassword"><span style="font-size: 12px;">Show
                                            Password</span>
                                    </div>
                                </div> -->

                                <span class="text-danger small" id="cfpassword-error" style="display: none"></span>

                                <br>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <button class="form-control btn btn-outline-info " type="submit" id="myButton"
                                            >Submit</button>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <a href="/emp/createemployeeinfo.html">Create Account</a>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <a href="https://www.w3schools.com">Forget Password</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="Assignment1.js"></script>
</body>

</html>
