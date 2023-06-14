# dthsubscription

AdminController:
POST /api/admin/channels: Create a new channel (requires ROLE_ADMIN)
PUT /api/admin/channels/{channelId}: Update an existing channel (requires ROLE_ADMIN)
DELETE /api/admin/channels/{channelId}: Delete a channel (requires ROLE_ADMIN)
POST /api/admin/packages: Create a new package (requires ROLE_ADMIN)
PUT /api/admin/packages/{packageId}: Update an existing package (requires ROLE_ADMIN)
DELETE /api/admin/packages/{packageId}: Delete a package (requires ROLE_ADMIN)
POST /api/admin/plans: Create a new plan (requires ROLE_ADMIN)
PUT /api/admin/plans/{planId}: Update an existing plan (requires ROLE_ADMIN)
DELETE /api/admin/plans/{planId}: Delete a plan (requires ROLE_ADMIN)
POST /api/admin/subscriptions: Create a new subscription (requires ROLE_ADMIN)
PUT /api/admin/subscriptions/{subscriptionId}: Update an existing subscription (requires ROLE_ADMIN)
DELETE /api/admin/subscriptions/{subscriptionId}: Delete a subscription (requires ROLE_ADMIN)

OperatorController:
POST /api/operator/subscriptions: Create a new subscription (requires ROLE_OPERATOR)
PUT /api/operator/subscriptions/{subscriptionId}: Update an existing subscription (requires ROLE_OPERATOR)
DELETE /api/operator/subscriptions/{subscriptionId}: Delete a subscription (requires ROLE_OPERATOR)

UserController:
GET /api/user/subscriptions: Get the list of subscriptions for the user (requires ROLE_USER)
POST /api/user/subscriptions: Create a new subscription (requires ROLE_USER)
PUT /api/user/subscriptions/{subscriptionId}: Update an existing subscription (requires ROLE_USER)
DELETE /api/user/subscriptions/{subscriptionId}: Delete a subscription (requires ROLE_USER)
