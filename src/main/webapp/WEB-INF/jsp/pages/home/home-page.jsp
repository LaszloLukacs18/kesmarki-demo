<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<html>
<head>
    <title>Demo</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="header-container">
        <div class="header">
            <div class="brand">
                Kesmarki Demo
            </div>
        </div>
    </div>
    <div class="sidebar-container">
        <div class="sidebar">
            <a class="sidebar-link" href="#">
                Add new Person
            </a>
            <a class="sidebar-link" href="#">
                List all persons
            </a>
        </div>
    </div>
    <div class="main-container">
        <div class="form-wrapper">
            <form:form  class="person-submit-form"
                        method="post"
                        action="/add-new-person"
                        modelAttribute="person">
                <div class="form-header">
                    Add New Person
                </div>
                <div class="input-wrapper">
                    <form:label path="firstName" class="input-label" for="firstName">First name</form:label>
                    <form:input path="firstName" class="input-field" type="text" id="firstName" placeholder="First name"/>
                </div>
                <div class="input-wrapper">
                    <form:label path="lastName" class="input-label" for="lastName">First name</form:label>
                    <form:input path="lastName" class="input-field" type="text" id="lastName" placeholder="Last name"/>
                </div>
                <div class="input-wrapper">
                    <label class="input-label">Permanent Address</label>
                    <div class="compound-input-panel">
                        <div class="input-wrapper">
                            <label class="input-label" for="postalCode">Postal code</label>
                            <input class="input-field" type="text" id="postalCode" name="postalCode"
                                   placeholder="City">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="city">City</label>
                            <input class="input-field" type="text" id="city" name="city"
                                   placeholder="City">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="street">Street</label>
                            <input class="input-field" type="text" id="street" name="street"
                                   placeholder="Street">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="houseNumber">House number</label>
                            <input class="input-field" type="text" id="houseNumber" name="houseNumber"
                                   placeholder="House number">
                        </div>
                    </div>
                </div>
                <div class="input-wrapper">
                    <label class="input-label">Temporary Address</label>
                    <div class="compound-input-panel">
                        <div class="input-wrapper">
                            <label class="input-label" for="postalCode">Postal code</label>
                            <input class="input-field" type="text" id="tmp-postalCode" name="postalCode"
                                   placeholder="City">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="city">City</label>
                            <input class="input-field" type="text" id="tmp-city" name="city"
                                   placeholder="City">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="street">Street</label>
                            <input class="input-field" type="text" id="tmp-street" name="street"
                                   placeholder="Street">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="houseNumber">House number</label>
                            <input class="input-field" type="text" id="tmp-houseNumber" name="houseNumber"
                                   placeholder="House number">
                        </div>
                    </div>
                </div>
                <div class="input-wrapper">
                    <label class="input-label">Contacts</label>
                    <div class="compound-input-panel">
                        <div class="input-wrapper">
                            <label class="input-label" for="contactType">Phone number</label>
                            <select class="select-field" type="text" id="contactType" name="contactType">
                                <option>Phone number</option>
                                <option>Email</option>
                            </select>
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="value">Contact Value</label>
                            <input class="input-field" type="text" id="value" name="value"
                                   placeholder="Contact value">
                        </div>
                        <a class="option-link" href="#">Add more contacts</a>
                    </div>
                </div>
                <button class="submit-button" type="submit">
                    Submit
                </button>
            </form:form>
        </div>

    </div>
</div>
</body>
</html>