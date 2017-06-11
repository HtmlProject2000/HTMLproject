 // Get the modal
function gomodelsidebar(){

            var modal = document.getElementById('modal-rate-this');
            
            // Get the button that opens the modal
            var a = document.getElementById("btn-sidenav");

            // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];

            // When the user clicks the button, open the modal 
            a.onclick = function() {
                modal.style.display = "block";
            }

            // When the user clicks on <span> (x), close the modal
            span.onclick = function() {
                modal.style.display = "none";
            }

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
}
function gomodellogin(){
    // Get the modal in login
            var modall = document.getElementById('modal-login');
            
            // Get the button that opens the modal login
            var al = document.getElementById("a-model-login");

            // Get the <span> element that closes the modal login
            var spanl = document.getElementsByClassName("closel")[0];

            // When the user clicks the button, open the modal login
            al.onclick = function() {
                modall.style.display = "block";
            }

            // When the user clicks on <span> (x), close the modal login
            spanl.onclick = function() {
                modall.style.display = "none";
            }

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modall) {
                    modall.style.display = "none";
                }
            }
}