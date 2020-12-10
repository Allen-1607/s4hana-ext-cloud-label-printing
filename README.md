# SAP S/4HANA Cloud Extensions: Label Printing Using SAP Cloud Platform Print Service
This repository contains the sample code for the [Label Printing Using SAP Cloud Platform Print Service tutorial](http://tiny.cc/s4-cloud-label-printing).

*This code is only one part of the tutorial, so please follow the tutorial before attempting to use this code.*

## Description

The [Label Printing Using SAP Cloud Platform Print Service tutorial](http://tiny.cc/s4-cloud-label-printing) uses the SAP Cloud Platform Print service to perform cloud printing. It showcases the printing of labels at a shipping point in the logistics department at a company, when goods are picked up from storage location and packed into packages for shipment. 

The label printing application retrieves delivery information from the SAP S/4HANA Cloud system. The shipping clerk can simply add the number of the packages they’ve created for each delivery line item. After choosing the print button, the system calculates the corresponding print labels based on delivery information and user input. 

The system triggers the forms by the Adobe service to render the print form and sends the print request to the print queue. The labels are then printed on the local printer at the shipping point. The label contains the delivery number, position, material number, quantity (per package), and the package number. The same information is also encoded in a QR code which can be used to scan the information easily, by the customer, for example.
 
#### SAP Extensibility Explorer

This tutorial is one of multiple tutorials that make up the [SAP Extensibility Explorer](https://sap.com/extends4) for SAP S/4HANA Cloud.
SAP Extensibility Explorer is a central place where anyone involved in the extensibility process can gain insight into various types of extensibility options. At the heart of SAP Extensibility Explorer, there is a rich repository of sample scenarios which show, in a hands-on way, how to realize an extensibility requirement leveraging different extensibility patterns.


Requirements
-------------
- An SAP Cloud Platform subaccount in the Neo environment with the Forms by Adobe service enabled and an SAP Cloud Platform Java server of any size.
- An SAP Cloud Platform subaccount in the Cloud Foundry environment with the Print service enabled.
- An SAP S/4HANA Cloud tenant. **This is a commercial paid product.**
- [Java SE 8 Development Kit (JDK)](https://www.oracle.com/technetwork/java/javase/downloads/index.html) to compile the Java application.
- [Apache Maven](http://maven.apache.org/download.cgi) to build the Java application.

Download and Installation
-------------
This repository is a part of the [Download the Application](https://help.sap.com/) step in the tutorial. Instructions for use can be found in that step.

[Please download the zip file by clicking here](https://github.wdf.sap.corp/staging-for-SAP-samples-public/s4hana-ext-cloud-label-printing/archive/master.zip) so that the code can be used in the tutorial.

Known issues
---------------------
If you are working with an SAP Cloud Platform _Trial_ account, you must add the following 2 properties to the destination so that the connection to SAP S/4HANA Cloud works:
```
proxyHost = proxy-trial.od.sap.biz
proxyPort = 8080
```

How to obtain support
---------------------
If you have issues with this sample, please open a report using [GitHub issues](https://github.com/SAP/s4hana-ext-cloud-label-printing/issues).

License
-------
Copyright © 2020 SAP SE or an SAP affiliate company. All rights reserved.
This project is licensed under the Apache Software License, version 2.0 except as noted otherwise in the [LICENSE file](LICENSES/Apache.txt).
