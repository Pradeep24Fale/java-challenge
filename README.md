# java-challenge
1. implemented JWT security for endpoint protection.(please check http://localhost:8080/swagger-ui.html)
   - access the above url.
   - run the authentication API.
     *Username: Admin Password: Admin.
   - this will generate JWT token.
   - copy this token and click Authorize button on header bar.
   - paste token inside input API_KEY text box in below formate.
      *Bearer {token}
      *note: please check space between.
   - then you can acess below employee API's.  
2. Added cache.
3. Added test cases.
4. fixed the bug in post api. (we are not suppose to provide Id while creating employee. Id should generate automatically.)
