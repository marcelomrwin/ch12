package com.packtpub.mjbeap7.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/PrivateServlet")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "mjeap7" }))
public class PrivateServlet extends HttpServlet {

    private static String PAGE_HEADER = "<html><head><title>Private Servlet</title></head><body>";

    private static String PAGE_FOOTER = "</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Principal principal = null;
        String authType = null;
        String remoteUser = null;

        // Get security principal
        principal = req.getUserPrincipal();
        // Get user name from login principal
        remoteUser = req.getRemoteUser();
        // Get authentication type
        authType = req.getAuthType();

        writer.println(PAGE_HEADER);
        writer.println("<h1>" + "Successfully called Private Servlet " + "</h1>");
        writer.println("<p>" + "Principal  : " + principal.getName() + "</p>");
        writer.println("<p>" + "Remote User : " + remoteUser + "</p>");
        writer.println("<p>" + "Authentication Type : " + authType + "</p>");
        writer.println("<p><a href=\"/basic-auth\" alt=\"Go back\">Go back</a></p>");
        writer.println(PAGE_FOOTER);
        writer.close();
    }

}
