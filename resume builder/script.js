//const form = document.getElementById("resume-form");
//const resume = document.getElementById("resume");


// Select the element to animate
var text = document.getElementById("animated-text");

// Define the animation
var animation = setInterval(function() {
  text.innerHTML = text.innerHTML.substring(1) + text.innerHTML.substring(0,1);
}, 100);

// form.addEventListener("submit", event => {
//   event.preventDefault();

//   const name = document.getElementById("name").value;
//   const jobTitle = document.getElementById("job-title").value;
//   const email = document.getElementById("email").value;
//   const phone = document.getElementById("phone").value;
//   const summary = document.getElementById("summary").value;

//   const education = document.getElementById("education").innerHTML;
//   const workExperience = document.getElement
// });


