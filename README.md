
Handshake
=========================

Handshake provides the B2B Commerce platform for manufacturers and distributors that powers standout ordering 
experiences both in-person and online. Companies using Handshake transform their sales effectiveness and drive 
operational efficiency, delighting customers and growing lasting relationships.

Installation and Usage
----------------------

For information about usage and installation you can check our documentation at http://mulesoft.github.com/handshake-connector.

Creation of resources and references
------------------------------------
Some creation methods allow to specify nested objects either as new or references to existing.

Whenever you want to create a object that references an existing one (for example, a new Order for an existing Customer), you just have to specify the resourceUri of the nested object.

    <handshake:create-order>
        <handshake:order>
            <handshake:customer resourceUri="/api/v2/customers/1"/>
        </handshake:create-order>
    </handshake:order>

However, you can also create a nested object alongside the master one.

    <handshake:create-order>
        <handshake:order>
            <handshake:customer id="SOME_ID" name="Some Customer">
                <handshake:bill-to city="Springfiled" stree="742 Evergreen Terrace"/>
            </handshake:customer>
        </handshake:create-order>
    </handshake:order>

When you create a new object through the API, the returned value will always contain a resourceUri attribute, which should be stored in your external system for future use as a reference.

Reporting Issues
----------------

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link https://github.com/mulesoft/handshake-connector/issues


Find something you don't like?
-----------------------------
Want to add your own magic to the connector? Go to [Contributing to Anypoint Community Connectors](http://mulesoft.github.io/connector-certification-docs/contr/index.html) and learn how you can also be a part of it.