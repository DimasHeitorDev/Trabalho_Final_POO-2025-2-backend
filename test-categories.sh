# Test Category Refactoring

# 1. Create Categories
echo "Creating categories..."
curl -X POST -H "Content-Type: application/json" -d '[{"nome": "Bebidas"}, {"nome": "Lanches"}]' http://localhost:8080/categorias
echo ""

# 2. List Categories
echo "Listing categories..."
curl http://localhost:8080/categorias
echo ""

# 3. Create Item with Category
echo "Creating item with category..."
# Assuming ID 1 is Bebidas
curl -X POST -H "Content-Type: application/json" -d '{"name": "Coca-Cola", "descricao": "Refrigerante", "preco": 5.0, "categoria": {"id": 1}, "imageUrl": "http://example.com/coke.jpg"}' http://localhost:8080/item
echo ""

# 4. List Items
echo "Listing items..."
curl http://localhost:8080/item
echo ""
