# Frontend of the Print Service Sample App

## How to run the application locally with mock data.    

### Prerequisites

1. [Node.js](https://nodejs.org/) has to be installed on your computer.
2. Open command prompt. Navigate to the _frontend_ folder. This folder will be referred to _root folder_ through this document.
3. Run the following command to configure NPM to use the SAP NPM registry:
   ```bash
   npm config set @sap:registry https://npm.sap.com
   ``` 
4. Run the following command to install dependencies:
   ```bash
   npm install
   ```

### Steps
1. To start the application via [ui5-cli](https://github.com/SAP/ui5-cli), execute the command in the root folder:
   ```bash
   npm start
   ```
   This will execute the script in `package.json` and therefore execute the command `ui5 serve` and start a local server. Please copy the link that is logged in the prompt (it should be in the form of `http://localhost:<port>/`).
2. Navigate to that link in your browser, i.e., open the link `http://localhost:<port>/` in your browser (e.g., chrome). You will see the the files are served in your local.
3. Navigate to `test/mockServer.html`
   This starts the application. The data you see will be mock data. 
   Application has no connection to backend.
   There, you can explore the application.

You have two options to run the tests. Either by using your browser or by using your browser or by using _karma test runner_.
1. **Run the tests in your browser:**
The application should be started in the local server with _ui5-cli_ as described above.
Then, to run the unit tests, you can navigate to `test/unit/unitTests.qunit.html`.
To run the OPA tests, you can navigate to `test/integration//opaTests.qunit.html`.
2. **Run the tests in with karma**
Run the command `npm run watch` in the root folder.
This command will use the configuration in the `karma.conf.js` file to run the tests with karma test runner.
Karma will run the tests automatically each time you make a change in one of the files.
You can change that behavior, by changing the line `autoWatch: true` to `autoWatch: false` in the configuration file.
