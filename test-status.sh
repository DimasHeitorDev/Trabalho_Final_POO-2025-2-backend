# Test Order Status

# 1. Create Order
echo "Creating order..."
# Assuming Item 1 exists (if not, create it first or use existing ID)
curl -X POST -H "Content-Type: application/json" -d '{"mesa": 10, "itens": {"1": 2}}' http://localhost:8080/pedidos
echo ""

# 2. List Orders (Check Status PENDENTE)
echo "Listing orders..."
curl http://localhost:8080/pedidos
echo ""

# 3. Update Status to COZINHANDO
echo "Updating status to COZINHANDO..."
# Assuming Order ID 1
curl -X PATCH "http://localhost:8080/pedidos/1/status?status=COZINHANDO"
echo ""

# 4. List Orders (Check Status COZINHANDO)
echo "Listing orders..."
curl http://localhost:8080/pedidos
echo ""
