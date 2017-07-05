var key = CheGWTGetKeyConvertigoMachineUrl();

var convertigoMachineUrl = localStorage.getItem(key);
CheGWTInjectDocReadyAndC8OCoreScripts(convertigoMachineUrl);

var mainViewId = document.getElementById("mainView");

// Label
var label = document.createElement("p");
label.textContent = "Enter a valid 7.5.x Convertigo server URL (pattern: http://{hostname}:{port})";

// Input
var input = document.createElement("input");
input.setAttribute("type", "text");
input.value = convertigoMachineUrl;

// Connect btn
var connectExtBtn = document.createElement("button");
connectExtBtn.setAttribute("type", "button");
connectExtBtn.textContent = "Update Convertigo server URL";
connectExtBtn.style = "white-space: nowrap;";
connectExtBtn.onclick = function () {
	var localConvertigoMachineUrl = input.value.trim();
	// Add "!" add the beginning of the URL to skip the test
	var isHackUrl = localConvertigoMachineUrl.startsWith("!");
	if (!isHackUrl && !/^http:\/\/.*:\d*\/?$/.test(localConvertigoMachineUrl)) {
		alert("Invalid URL.\nPlease try to enter another URL in the Convertigo URL panel (pattern: http://{hostname}:{port}).")
	}
	else {
		if (isHackUrl) {
			localConvertigoMachineUrl = localConvertigoMachineUrl.replace("!", "");
		}
		
		localStorage.setItem(key, localConvertigoMachineUrl);
		location.reload();
	}
};

var convertigoMachineUrl = CheGWTGetConvertigoMachineUrl();
if (convertigoMachineUrl !== null) {
	var connectIntBtn = document.createElement("button");
	connectIntBtn.setAttribute("type", "button");
	connectIntBtn.textContent = "Connect CHE to the Convertigo server machine (stack)";
	connectIntBtn.style = "white-space: nowrap;";
	connectIntBtn.onclick = function () {
		localStorage.setItem(key, convertigoMachineUrl);
		location.reload();
	}
}

var localhostUrl = "http://localhost:18080";
mainViewId.appendChild(label);
mainViewId.appendChild(input);
if (localStorage.getItem(key) === convertigoMachineUrl && CheGWTGetConvertigoMachineUrl() !== localhostUrl) {
	var intMsg = document.createElement("p");
	intMsg.textContent = "NOTE: The entered URL refers to the Convertigo server machine (stack).";
	intMsg.style = "color: red";
	mainViewId.appendChild(intMsg);
}
else if (localStorage.getItem(key) === localhostUrl) {
	var localhostMsg = document.createElement("p");
	localhostMsg.textContent = "NOTE: The entered URL refers to the localhost Convertigo server.";
	localhostMsg.style = "color: red";
	mainViewId.appendChild(localhostMsg);
}

mainViewId.appendChild(connectExtBtn);

mainViewId.appendChild(document.createElement("hr"));
var localhostMsg = document.createElement("p");
localhostMsg.textContent = "You can click on the button just below to connect CHE to the localhost Convertigo server without typing the URL.";
mainViewId.appendChild(localhostMsg);
var connectLocalHostBtn = document.createElement("button");
connectLocalHostBtn.setAttribute("type", "button");
connectLocalHostBtn.textContent = "Connect CHE to the localhost Convertigo server";
connectLocalHostBtn.style = "white-space: nowrap;";
connectLocalHostBtn.onclick = function () {
	localStorage.setItem(key, localhostUrl);
	location.reload();
}
mainViewId.appendChild(connectLocalHostBtn);

if (convertigoMachineUrl !== null && CheGWTGetConvertigoMachineUrl() !== localhostUrl) {
	mainViewId.appendChild(document.createElement("hr"));
	var orMsg = document.createElement("p");
	orMsg.textContent = "Or you can directly connect CHE to the Convertigo server machine (stack)";
	mainViewId.appendChild(orMsg);
	mainViewId.appendChild(connectIntBtn);
}
