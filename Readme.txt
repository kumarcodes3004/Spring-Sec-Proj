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


    @Bean
    public AuthenticationProvider authProivder(){
        //this Class  DaoAuthenticationProvider ->helps to deal with user from db
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //this wont work alone, we need to tell about the db and classes
        //User table name , how we represnt the class

        provider.setUserDetailsService(userDetailsService);
        //not using any password encoder
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }
      # DaoAuthenticationProvider -> helps to deal with actual uysers frfom db.which helps in dealing with multiple users rather than hardcoding

      #   provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); -> used to match the password in db with the username
        For different type of authetication we have different type of Auth provider
        ->Since we are working with database we have DaoAutheticationProvider
        #DAO->data access object