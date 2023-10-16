import { Text, View } from "react-native";

export default function App({ product = { name: "Apple", price: "1 dollar" } }) {
  return (
    <View style={{ flexDirection: "row", marginTop: 100 }}>
      <Text style={{ flex: 1 }}>{product.name}</Text>
      <Text style={{ width: 50 }}>{product.price}</Text>
    </View>
  );
}
