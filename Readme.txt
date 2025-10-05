    public UserDetailsService userDetailsService() {
        //not actual way of doing as the users will be coming from db
       //we can have multiple users here as well
        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("satyam")
                .password("111")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user);

    }

    This wont bve done in actaul project as we will be gettting users from DB.

    For that we have a Authentication Provider (as we have multiple types of auth)
    we send a AutheicatedObject to the provider it verifies and gives the access

    This AuthenticationProvider will deal with db.

    ////////////////////////////////////////////////////////////////


    public AuthenticationProvider authProivder(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        return provider;
    }}

        For different type of authetication we have different type of Auth provider
        ->Since we are working with database we have DaoAutheticationProvider
        #DAO->data access object