// CHECKSTYLE:OFF

package hudson.security;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

@SuppressWarnings({
    "",
    "PMD"
})
public class Messages {

    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Jenkins’s own user database
     * 
     */
    public static String HudsonPrivateSecurityRealm_DisplayName() {
        return holder.format("HudsonPrivateSecurityRealm.DisplayName");
    }

    /**
     * Jenkins’s own user database
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_DisplayName() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.DisplayName");
    }

    /**
     * Invalid port number
     * 
     */
    public static String LDAPSecurityRealm_InvalidPortNumber() {
        return holder.format("LDAPSecurityRealm.InvalidPortNumber");
    }

    /**
     * Invalid port number
     * 
     */
    public static Localizable _LDAPSecurityRealm_InvalidPortNumber() {
        return new Localizable(holder, "LDAPSecurityRealm.InvalidPortNumber");
    }

    /**
     * Unable to connect to {0} : {1}
     * 
     */
    public static String LDAPSecurityRealm_UnableToConnect(Object arg1, Object arg2) {
        return holder.format("LDAPSecurityRealm.UnableToConnect", arg1, arg2);
    }

    /**
     * Unable to connect to {0} : {1}
     * 
     */
    public static Localizable _LDAPSecurityRealm_UnableToConnect(Object arg1, Object arg2) {
        return new Localizable(holder, "LDAPSecurityRealm.UnableToConnect", arg1, arg2);
    }

    /**
     * {0} is missing the {1} permission
     * 
     */
    public static String AccessDeniedException2_MissingPermission(Object arg1, Object arg2) {
        return holder.format("AccessDeniedException2.MissingPermission", arg1, arg2);
    }

    /**
     * {0} is missing the {1} permission
     * 
     */
    public static Localizable _AccessDeniedException2_MissingPermission(Object arg1, Object arg2) {
        return new Localizable(holder, "AccessDeniedException2.MissingPermission", arg1, arg2);
    }

    /**
     * Configure Global Security
     * 
     */
    public static String GlobalSecurityConfiguration_DisplayName() {
        return holder.format("GlobalSecurityConfiguration.DisplayName");
    }

    /**
     * Configure Global Security
     * 
     */
    public static Localizable _GlobalSecurityConfiguration_DisplayName() {
        return new Localizable(holder, "GlobalSecurityConfiguration.DisplayName");
    }

    /**
     * User name is already taken
     * 
     */
    public static String HudsonPrivateSecurityRealm_CreateAccount_UserNameAlreadyTaken() {
        return holder.format("HudsonPrivateSecurityRealm.CreateAccount.UserNameAlreadyTaken");
    }

    /**
     * User name is already taken
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_CreateAccount_UserNameAlreadyTaken() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.CreateAccount.UserNameAlreadyTaken");
    }

    /**
     * Legacy mode
     * 
     */
    public static String LegacyAuthorizationStrategy_DisplayName() {
        return holder.format("LegacyAuthorizationStrategy.DisplayName");
    }

    /**
     * Legacy mode
     * 
     */
    public static Localizable _LegacyAuthorizationStrategy_DisplayName() {
        return new Localizable(holder, "LegacyAuthorizationStrategy.DisplayName");
    }

    /**
     * Unix user/group database
     * 
     */
    public static String PAMSecurityRealm_DisplayName() {
        return holder.format("PAMSecurityRealm.DisplayName");
    }

    /**
     * Unix user/group database
     * 
     */
    public static Localizable _PAMSecurityRealm_DisplayName() {
        return new Localizable(holder, "PAMSecurityRealm.DisplayName");
    }

    /**
     * Project-based Matrix Authorization Strategy
     * 
     */
    public static String ProjectMatrixAuthorizationStrategy_DisplayName() {
        return holder.format("ProjectMatrixAuthorizationStrategy.DisplayName");
    }

    /**
     * Project-based Matrix Authorization Strategy
     * 
     */
    public static Localizable _ProjectMatrixAuthorizationStrategy_DisplayName() {
        return new Localizable(holder, "ProjectMatrixAuthorizationStrategy.DisplayName");
    }

    /**
     * Unable to query user information: {0}
     * 
     */
    public static String UserDetailsServiceProxy_UnableToQuery(Object arg1) {
        return holder.format("UserDetailsServiceProxy.UnableToQuery", arg1);
    }

    /**
     * Unable to query user information: {0}
     * 
     */
    public static Localizable _UserDetailsServiceProxy_UnableToQuery(Object arg1) {
        return new Localizable(holder, "UserDetailsServiceProxy.UnableToQuery", arg1);
    }

    /**
     * Anyone can do anything
     * 
     */
    public static String AuthorizationStrategy_DisplayName() {
        return holder.format("AuthorizationStrategy.DisplayName");
    }

    /**
     * Anyone can do anything
     * 
     */
    public static Localizable _AuthorizationStrategy_DisplayName() {
        return new Localizable(holder, "AuthorizationStrategy.DisplayName");
    }

    /**
     * The confirmed password is not the same as the one entered. Please make sure to type the same password twice.
     * 
     */
    public static String HudsonPrivateSecurityRealm_Details_PasswordError() {
        return holder.format("HudsonPrivateSecurityRealm.Details.PasswordError");
    }

    /**
     * The confirmed password is not the same as the one entered. Please make sure to type the same password twice.
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_Details_PasswordError() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.Details.PasswordError");
    }

    /**
     * Current User
     * 
     */
    public static String PAMSecurityRealm_CurrentUser() {
        return holder.format("PAMSecurityRealm.CurrentUser");
    }

    /**
     * Current User
     * 
     */
    public static Localizable _PAMSecurityRealm_CurrentUser() {
        return new Localizable(holder, "PAMSecurityRealm.CurrentUser");
    }

    /**
     * Manage Users
     * 
     */
    public static String HudsonPrivateSecurityRealm_ManageUserLinks_DisplayName() {
        return holder.format("HudsonPrivateSecurityRealm.ManageUserLinks.DisplayName");
    }

    /**
     * Manage Users
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_ManageUserLinks_DisplayName() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.ManageUserLinks.DisplayName");
    }

    /**
     * Password is required
     * 
     */
    public static String HudsonPrivateSecurityRealm_CreateAccount_PasswordRequired() {
        return holder.format("HudsonPrivateSecurityRealm.CreateAccount.PasswordRequired");
    }

    /**
     * Password is required
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_CreateAccount_PasswordRequired() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.CreateAccount.PasswordRequired");
    }

    /**
     * Syntax of server field is SERVER or SERVER:PORT or ldaps://SERVER[:PORT]
     * 
     */
    public static String LDAPSecurityRealm_SyntaxOfServerField() {
        return holder.format("LDAPSecurityRealm.SyntaxOfServerField");
    }

    /**
     * Syntax of server field is SERVER or SERVER:PORT or ldaps://SERVER[:PORT]
     * 
     */
    public static Localizable _LDAPSecurityRealm_SyntaxOfServerField() {
        return new Localizable(holder, "LDAPSecurityRealm.SyntaxOfServerField");
    }

    /**
     * User name is required
     * 
     */
    public static String HudsonPrivateSecurityRealm_CreateAccount_UserNameRequired() {
        return holder.format("HudsonPrivateSecurityRealm.CreateAccount.UserNameRequired");
    }

    /**
     * User name is required
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_CreateAccount_UserNameRequired() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.CreateAccount.UserNameRequired");
    }

    /**
     * Delegate to servlet container
     * 
     */
    public static String LegacySecurityRealm_Displayname() {
        return holder.format("LegacySecurityRealm.Displayname");
    }

    /**
     * Delegate to servlet container
     * 
     */
    public static Localizable _LegacySecurityRealm_Displayname() {
        return new Localizable(holder, "LegacySecurityRealm.Displayname");
    }

    /**
     * Either Jenkins needs to run as {0} or {1} needs to belong to group {2} and ‘chmod g+r /etc/shadow’ needs to be done to enable Jenkins to read /etc/shadow
     * 
     */
    public static String PAMSecurityRealm_RunAsUserOrBelongToGroupAndChmod(Object arg1, Object arg2, Object arg3) {
        return holder.format("PAMSecurityRealm.RunAsUserOrBelongToGroupAndChmod", arg1, arg2, arg3);
    }

    /**
     * Either Jenkins needs to run as {0} or {1} needs to belong to group {2} and ‘chmod g+r /etc/shadow’ needs to be done to enable Jenkins to read /etc/shadow
     * 
     */
    public static Localizable _PAMSecurityRealm_RunAsUserOrBelongToGroupAndChmod(Object arg1, Object arg2, Object arg3) {
        return new Localizable(holder, "PAMSecurityRealm.RunAsUserOrBelongToGroupAndChmod", arg1, arg2, arg3);
    }

    /**
     * Password
     * 
     */
    public static String HudsonPrivateSecurityRealm_Details_DisplayName() {
        return holder.format("HudsonPrivateSecurityRealm.Details.DisplayName");
    }

    /**
     * Password
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_Details_DisplayName() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.Details.DisplayName");
    }

    /**
     * Password didn't match
     * 
     */
    public static String HudsonPrivateSecurityRealm_CreateAccount_PasswordNotMatch() {
        return holder.format("HudsonPrivateSecurityRealm.CreateAccount.PasswordNotMatch");
    }

    /**
     * Password didn't match
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_CreateAccount_PasswordNotMatch() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.CreateAccount.PasswordNotMatch");
    }

    /**
     * Jenkins needs to be able to read /etc/shadow
     * 
     */
    public static String PAMSecurityRealm_ReadPermission() {
        return holder.format("PAMSecurityRealm.ReadPermission");
    }

    /**
     * Jenkins needs to be able to read /etc/shadow
     * 
     */
    public static Localizable _PAMSecurityRealm_ReadPermission() {
        return new Localizable(holder, "PAMSecurityRealm.ReadPermission");
    }

    /**
     * This {0} {1} is new to Jenkins. Would you like to sign up?
     * 
     */
    public static String HudsonPrivateSecurityRealm_WouldYouLikeToSignUp(Object arg1, Object arg2) {
        return holder.format("HudsonPrivateSecurityRealm.WouldYouLikeToSignUp", arg1, arg2);
    }

    /**
     * This {0} {1} is new to Jenkins. Would you like to sign up?
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_WouldYouLikeToSignUp(Object arg1, Object arg2) {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.WouldYouLikeToSignUp", arg1, arg2);
    }

    /**
     * LDAP
     * 
     */
    public static String LDAPSecurityRealm_DisplayName() {
        return holder.format("LDAPSecurityRealm.DisplayName");
    }

    /**
     * LDAP
     * 
     */
    public static Localizable _LDAPSecurityRealm_DisplayName() {
        return new Localizable(holder, "LDAPSecurityRealm.DisplayName");
    }

    /**
     * uid: {0}
     * 
     */
    public static String PAMSecurityRealm_Uid(Object arg1) {
        return holder.format("PAMSecurityRealm.Uid", arg1);
    }

    /**
     * uid: {0}
     * 
     */
    public static Localizable _PAMSecurityRealm_Uid(Object arg1) {
        return new Localizable(holder, "PAMSecurityRealm.Uid", arg1);
    }

    /**
     * Unknown host: {0}
     * 
     */
    public static String LDAPSecurityRealm_UnknownHost(Object arg1) {
        return holder.format("LDAPSecurityRealm.UnknownHost", arg1);
    }

    /**
     * Unknown host: {0}
     * 
     */
    public static Localizable _LDAPSecurityRealm_UnknownHost(Object arg1) {
        return new Localizable(holder, "LDAPSecurityRealm.UnknownHost", arg1);
    }

    /**
     * Secure Jenkins; define who is allowed to access/use the system.
     * 
     */
    public static String GlobalSecurityConfiguration_Description() {
        return holder.format("GlobalSecurityConfiguration.Description");
    }

    /**
     * Secure Jenkins; define who is allowed to access/use the system.
     * 
     */
    public static Localizable _GlobalSecurityConfiguration_Description() {
        return new Localizable(holder, "GlobalSecurityConfiguration.Description");
    }

    /**
     * {0} needs to belong to group {1} to read /etc/shadow
     * 
     */
    public static String PAMSecurityRealm_BelongToGroup(Object arg1, Object arg2) {
        return holder.format("PAMSecurityRealm.BelongToGroup", arg1, arg2);
    }

    /**
     * {0} needs to belong to group {1} to read /etc/shadow
     * 
     */
    public static Localizable _PAMSecurityRealm_BelongToGroup(Object arg1, Object arg2) {
        return new Localizable(holder, "PAMSecurityRealm.BelongToGroup", arg1, arg2);
    }

    /**
     * Logged-in users can do anything
     * 
     */
    public static String FullControlOnceLoggedInAuthorizationStrategy_DisplayName() {
        return holder.format("FullControlOnceLoggedInAuthorizationStrategy.DisplayName");
    }

    /**
     * Logged-in users can do anything
     * 
     */
    public static Localizable _FullControlOnceLoggedInAuthorizationStrategy_DisplayName() {
        return new Localizable(holder, "FullControlOnceLoggedInAuthorizationStrategy.DisplayName");
    }

    /**
     * Create/delete/modify users that can log in to this Jenkins
     * 
     */
    public static String HudsonPrivateSecurityRealm_ManageUserLinks_Description() {
        return holder.format("HudsonPrivateSecurityRealm.ManageUserLinks.Description");
    }

    /**
     * Create/delete/modify users that can log in to this Jenkins
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_ManageUserLinks_Description() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.ManageUserLinks.Description");
    }

    /**
     * N/A
     * 
     */
    public static String Permission_Permissions_Title() {
        return holder.format("Permission.Permissions.Title");
    }

    /**
     * N/A
     * 
     */
    public static Localizable _Permission_Permissions_Title() {
        return new Localizable(holder, "Permission.Permissions.Title");
    }

    /**
     * Matrix-based security
     * 
     */
    public static String GlobalMatrixAuthorizationStrategy_DisplayName() {
        return holder.format("GlobalMatrixAuthorizationStrategy.DisplayName");
    }

    /**
     * Matrix-based security
     * 
     */
    public static Localizable _GlobalMatrixAuthorizationStrategy_DisplayName() {
        return new Localizable(holder, "GlobalMatrixAuthorizationStrategy.DisplayName");
    }

    /**
     * Invalid e-mail address
     * 
     */
    public static String HudsonPrivateSecurityRealm_CreateAccount_InvalidEmailAddress() {
        return holder.format("HudsonPrivateSecurityRealm.CreateAccount.InvalidEmailAddress");
    }

    /**
     * Invalid e-mail address
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_CreateAccount_InvalidEmailAddress() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.CreateAccount.InvalidEmailAddress");
    }

    /**
     * User ‘{0}’
     * 
     */
    public static String PAMSecurityRealm_User(Object arg1) {
        return holder.format("PAMSecurityRealm.User", arg1);
    }

    /**
     * User ‘{0}’
     * 
     */
    public static Localizable _PAMSecurityRealm_User(Object arg1) {
        return new Localizable(holder, "PAMSecurityRealm.User", arg1);
    }

    /**
     * Success
     * 
     */
    public static String PAMSecurityRealm_Success() {
        return holder.format("PAMSecurityRealm.Success");
    }

    /**
     * Success
     * 
     */
    public static Localizable _PAMSecurityRealm_Success() {
        return new Localizable(holder, "PAMSecurityRealm.Success");
    }

    /**
     * Text didn't match the word shown in the image
     * 
     */
    public static String HudsonPrivateSecurityRealm_CreateAccount_TextNotMatchWordInImage() {
        return holder.format("HudsonPrivateSecurityRealm.CreateAccount.TextNotMatchWordInImage");
    }

    /**
     * Text didn't match the word shown in the image
     * 
     */
    public static Localizable _HudsonPrivateSecurityRealm_CreateAccount_TextNotMatchWordInImage() {
        return new Localizable(holder, "HudsonPrivateSecurityRealm.CreateAccount.TextNotMatchWordInImage");
    }

}
