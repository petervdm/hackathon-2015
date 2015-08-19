require 'test_helper'

class DisplaydataControllerTest < ActionController::TestCase
  setup do
    @displaydatum = displaydata(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:displaydata)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create displaydatum" do
    assert_difference('Displaydatum.count') do
      post :create, displaydatum: { cloud: @displaydatum.cloud, hour: @displaydatum.hour, image_loc: @displaydatum.image_loc, infodate: @displaydatum.infodate, negative: @displaydatum.negative, neutral: @displaydatum.neutral, positive: @displaydatum.positive }
    end

    assert_redirected_to displaydatum_path(assigns(:displaydatum))
  end

  test "should show displaydatum" do
    get :show, id: @displaydatum
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @displaydatum
    assert_response :success
  end

  test "should update displaydatum" do
    patch :update, id: @displaydatum, displaydatum: { cloud: @displaydatum.cloud, hour: @displaydatum.hour, image_loc: @displaydatum.image_loc, infodate: @displaydatum.infodate, negative: @displaydatum.negative, neutral: @displaydatum.neutral, positive: @displaydatum.positive }
    assert_redirected_to displaydatum_path(assigns(:displaydatum))
  end

  test "should destroy displaydatum" do
    assert_difference('Displaydatum.count', -1) do
      delete :destroy, id: @displaydatum
    end

    assert_redirected_to displaydata_path
  end
end
