<div id="footer">
    <div id="manage" class="floating thitrythree">
        <c:choose>
            <c:when test="${loggedUser.role == 'ADMIN'}">
                <h6>TODO : INSERIRE COLLEGAMENTO A MANAGEMENT PAGE</h6>
            </c:when>
            <c:otherwise>
                <span>Copyright 2018 Gucci. Inc</span>
            </c:otherwise>
        </c:choose>
    </div>
    
    <div id="contact_us" class="floating thitrythree">
        <span> CONTACT US </span> <br>
        <span>gucci@gucci.com</span><br>
        <span>+39 0001234567</span>
    </div>
    
    <div id="follow_us" class="floating thitrythree">
        <a target="_blank" title="follow me on instagram" href="http://www.instagram.com/gucci/"><img alt="follow me on instagram" src="https://c866088.ssl.cf3.rackcdn.com/assets/instagram30x30.png" border=0></a>
        <a target="_blank" title="follow me on Twitter" href="http://www.twitter.com/gucci"><img alt="follow me on Twitter" src="https://c866088.ssl.cf3.rackcdn.com/assets/twitter30x30.png" border=0></a>
        <a target="_blank" title="follow me on facebook" href="http://www.facebook.com/GUCCI/"><img alt="follow me on facebook" src="https://c866088.ssl.cf3.rackcdn.com/assets/facebook30x30.png" border=0></a>
    </div>
</div>

<script src="/risorse/node_modules/jquery/dist/jquery.js"></script>
<script src="/risorse/node_modules/mustache/mustache.js"></script>
<script type="text/javascript" src="/risorse/javascript/index.js"></script>
</body>
</html>