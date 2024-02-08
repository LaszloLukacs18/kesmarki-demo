<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <form class="person-submit-form">
                <div class="form-header">
                    Add New Person
                </div>
                <div class="input-wrapper">
                    <label class="input-label" for="first-name">First name</label>
                    <input class="input-field" type="text" id="first-name" name="first-name" placeholder="First name">
                </div>
                <div class="input-wrapper">
                    <label class="input-label" for="last-name">Last name</label>
                    <input class="input-field" type="text" id="last-name"
                           name="last-name" placeholder="Last name">
                </div>
                <div class="input-wrapper">
                    <label class="input-label">Permanent Address</label>
                    <div class="compound-input-panel">
                        <div class="input-wrapper">
                            <label class="input-label" for="postal-code">Postal code</label>
                            <input class="input-field" type="text" id="postal-code" name="postal-code"
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
                            <label class="input-label" for="house-number">House number</label>
                            <input class="input-field" type="text" id="house-number" name="house-number"
                                   placeholder="House number">
                        </div>
                    </div>
                </div>
                <div class="input-wrapper">
                    <label class="input-label">Temporary Address</label>
                    <div class="compound-input-panel">
                        <div class="input-wrapper">
                            <label class="input-label" for="temp-postal-code">Postal code</label>
                            <input class="input-field" type="text" id="temp-postal-code" name="postal-code"
                                   placeholder="City">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="temp-city">City</label>
                            <input class="input-field" type="text" id="temp-city" name="city"
                                   placeholder="City">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="temp-street">Street</label>
                            <input class="input-field" type="text" id="temp-street" name="street"
                                   placeholder="Street">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="temp-house-number">House number</label>
                            <input class="input-field" type="text" id="temp-house-number" name="house-number"
                                   placeholder="House number">
                        </div>
                    </div>
                </div>
                <div class="input-wrapper">
                    <label class="input-label">Contacts</label>
                    <div class="compound-input-panel">
                        <div class="input-wrapper">
                            <label class="input-label" for="contact-type">Phone number</label>
                            <input class="input-field" type="text" id="contact-type" name="contact-type"
                                   placeholder="Contact type">
                        </div>
                        <div class="input-wrapper">
                            <label class="input-label" for="contact-value">Contact Value</label>
                            <input class="input-field" type="text" id="contact-value" name="contact-value"
                                   placeholder="Contact value">
                        </div>
                        <a class="option-link" href="#">Add more contacts</a>
                    </div>
                </div>
                <button class="submit-button" type="submit">
                    Submit
                </button>
            </form>
        </div>

    </div>
</div>
</body>
</html>