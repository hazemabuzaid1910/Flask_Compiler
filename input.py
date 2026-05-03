from flask import Flask, render_template, request, redirect
import json

app = Flask(__name__)

DATA_FILE = "products.json"


# تحميل المنتجات من JSON
def load_products():
    with open(DATA_FILE, "r") as file:
        return json.load(file)


# حفظ المنتجات إلى JSON
def save_products(products):
    with open(DATA_FILE, "w") as file:
        json.dump(products, file, indent=2)


# الصفحة الرئيسية
@app.route("/")
def home():
    products = load_products()
    return render_template("index.html", products=products)


# صفحة إضافة منتج
@app.route("/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        products = load_products()

        new_product = {
            "id": len(products) + 1,
            "name": request.form["name"],
            "price": request.form["price"],
            "image": request.form["image"]
        }

        products.append(new_product)
        save_products(products)

        return redirect("/")

    return render_template("add.html")


# حذف منتج
@app.route("/delete/<int:product_id>")
def delete_product(product_id):
    products = load_products()

    products = [p for p in products if p["id"] != product_id]

    save_products(products)
    return redirect("/")


# تعديل منتج
@app.route("/edit/<int:product_id>", methods=["GET", "POST"])
def edit_product(product_id):
    products = load_products()

    product = None
    for p in products:
        if p["id"] == product_id:
            product = p

    if request.method == "POST":
        product["name"] = request.form["name"]
        product["price"] = request.form["price"]
        product["image"] = request.form["image"]

        save_products(products)
        return redirect("/")

    return render_template("edit.html", product=product)




if __name__ == "__main__":
    app.run(debug=True)
