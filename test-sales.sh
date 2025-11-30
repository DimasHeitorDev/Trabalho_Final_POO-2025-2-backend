# Test Daily Sales

# 1. Check Initial Sales
echo "Checking initial sales..."
curl http://localhost:8080/vendas/hoje
echo ""

# 2. Create Order (Price should be calculated)
echo "Creating order..."
# Assuming Item 1 exists and has a price (e.g. 5.0)
curl -X POST -H "Content-Type: application/json" -d '{"mesa": 10, "itens": {"1": 2}}' http://localhost:8080/pedidos
echo ""

# 3. Get Order ID (Manually check output or assume ID)
# Let's assume the new order ID is returned in the previous step.

# 4. Complete Order (Update status to CONCLUIDO)
echo "Completing order (ID 1)..."
curl -X PATCH "http://localhost:8080/pedidos/1/status?status=CONCLUIDO"
echo ""

# 5. Check Sales Again (Should increase by order total)
echo "Checking sales after completion..."
curl http://localhost:8080/vendas/hoje
echo ""
